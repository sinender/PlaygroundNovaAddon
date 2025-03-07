package com.example.window

import xyz.xenondevs.invui.window.AbstractSplitWindow
import xyz.xenondevs.invui.window.Window

abstract class AlternativeWindow {
    abstract fun createWindow(): AbstractSplitWindow
}