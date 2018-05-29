# sbt-evil-mode

Don't do this. Don't do any of it.

## Usage

```sbt
// in plugins.sbt
addSbtPlugin("com.codecommit" % "sbt-evil-mode" % "0.1-53ac5ef")
```

### GitHub Source Dependencies

```sbt
lazy val root = project
  .in(file("."))
  .gitHubDependency("djspiewak", "scala-collections", "c785a40")
```

The above creates a source dependency on hash `c785a40` of the [djspiewak/scala-collections](https://github.com/djspiewak/scala-collections) project on github. Don't do this. Oh, tags probably also work. Haven't tried it. You shouldn't either.

Now, if you're *truly* an evil person (let's face it, why else would you be reading this?), then what you probably really want is a way to depend on `HEAD` of a given project. Mercifully, SBT prevents this due to entirely unrelated architectural constraints. So you can't!

...yet
