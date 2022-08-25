package com.jtarnoff.midtronicssample.utils

class ClickListener(val clickListener: (itemId: String) -> Unit)
{
    fun onClick(item: String) = clickListener(item)
}