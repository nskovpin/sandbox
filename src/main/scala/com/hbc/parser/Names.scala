package com.hbc.parser

object Names {
    sealed trait Name
    case object Nikolay extends Name
    case object Taylor extends Name
    case object Alex extends Name
    case object Daniel extends Name
}