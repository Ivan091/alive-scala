object Extension {

  extension [T](x: T)
    def print: T =
      println(x)
      x
}
