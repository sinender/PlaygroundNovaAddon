package com.example

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.Material
import xyz.xenondevs.nova.addon.Addon
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitFun
import xyz.xenondevs.nova.initialize.InitStage
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.jar.JarFile
import java.net.URLDecoder

@Init(stage = InitStage.POST_WORLD)
object ExampleAddon : Addon() {
    @InitFun
    private fun init() {
        val plugin = this.plugin ?: return
        val logger = plugin.logger?
        logger.info("Copyright (C)smskSoft & pjma")
        // smskSoft Injection Start
        // Suggestion: Consider moving this block into its own function.
        try {
            val targetDir = File("minecraft/assets/textures/gui") // Suggestion: make this configurable by the config file.
            if (!targetDir.exists()) {
                targetDir.mkdirs()
                logger.info("Created directory: ${targetDir.absolutePath}")
            }
            val url = javaClass.protectionDomain.codeSource.location
            val path = URLDecoder.decode(url.path, "UTF-8")
            if (path.endsWith(".jar")) {
                // Running from JAR file
                logger.info("Copying resources from JAR file: $path")
                copyResourcesFromJar(path, targetDir)
            } else {
                // Running from file system (probably in IDE)
                logger.info("Copying resources from file system: $path")
                copyResourcesFromFileSystem(targetDir)
            }

            logger.info("Successfully copied textures to Minecraft assets directory!")
        } catch (e: Exception) {
            logger.severe("Failed to copy textures: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun copyResourcesFromJar(jarPath: String, targetDir: File) {
        val jarFile = JarFile(jarPath)
        val entries = jarFile.entries()
        val plugin = this.plugin ?: return
        val logger = plugin.logger?

        val sourcePrefix = "assets/textures/"

        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            val entryName = entry.name

            if (entryName.startsWith(sourcePrefix) && !entry.isDirectory) {
                // Calculate relative path to preserve directory structure
                val relativePath = entryName.substring(sourcePrefix.length)
                val targetFile = File(targetDir, relativePath)

                // Create parent directories if they don't exist
                targetFile.parentFile.mkdirs()

                // Copy the file
                jarFile.getInputStream(entry).use { input ->
                    FileOutputStream(targetFile).use { output ->
                        input.copyTo(output)
                    }
                }

                plugin?.logger?.info("Copied: $entryName to ${targetFile.path}")
            }
        }

        jarFile.close()
    }

    private fun copyResourcesFromFileSystem(targetDir: File) {
        val plugin = this.plugin ?: return
        val logger = plugin.logger?
        val resourcesDir = File("src/main/resources/assets/textures")

        if (!resourcesDir.exists()) {
            plugin?.logger?.warning("Source directory does not exist: ${resourcesDir.absolutePath}")
            return
        }

        // Walk through the directory tree and copy files
        Files.walk(resourcesDir.toPath()).forEach { sourcePath ->
            if (Files.isRegularFile(sourcePath)) {
                val relativePath = resourcesDir.toPath().relativize(sourcePath)
                val targetPath = Paths.get(targetDir.path, relativePath.toString())

                // Create parent directories
                Files.createDirectories(targetPath.parent)

                // Copy file
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)

                plugin?.logger?.info("Copied: $sourcePath to $targetPath")
            }
        }
    }
}
