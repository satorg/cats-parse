import com.typesafe.tools.mima.core.{
  ProblemFilters,
  IncompatibleMethTypeProblem,
  IncompatibleResultTypeProblem,
  DirectMissingMethodProblem,
  MissingClassProblem
}

object MimaExclusionRules {
  val parserImpl = Seq(
    "cats.parse.Parser#Impl.mergeCharIn",
    "cats.parse.Parser#Impl.mergeStrIn",
    "cats.parse.Parser#Impl#CharIn.copy",
    "cats.parse.Parser#Impl#CharIn.apply",
    "cats.parse.Parser#Impl#CharIn.this"
  ).map(ProblemFilters.exclude[IncompatibleMethTypeProblem](_)) ++ Seq(
    "cats.parse.Parser#Impl#StringIn.parseMut",
    "cats.parse.Parser#Impl.stringIn",
    "cats.parse.Parser#Impl#CharIn.copy$default$2",
    "cats.parse.Parser#Impl#CharIn.bitSet",
    "cats.parse.Parser#Impl#CharIn._2"
  ).map(ProblemFilters.exclude[IncompatibleResultTypeProblem](_)) ++ Seq(
    "cats.parse.Parser#Impl.mergeCharIn",
    "cats.parse.Parser#Impl.mergeStrIn"
  ).map(ProblemFilters.exclude[DirectMissingMethodProblem](_)) ++ Seq(
    "cats.parse.Parser$Impl$Rep0",
    "cats.parse.Parser$Impl$Rep0$"
  ).map(ProblemFilters.exclude[MissingClassProblem](_))

  // TODO: Remove these rules in future release.
  val bitSetUtil = Seq(
    "cats.parse.BitSetUtil.isSingleton",
    "cats.parse.BitSetUtil.isSet"
  ).map(ProblemFilters.exclude[IncompatibleMethTypeProblem](_)) ++ Seq(
    "cats.parse.BitSetUtil.bitSetFor"
  ).map(ProblemFilters.exclude[IncompatibleResultTypeProblem](_))
}
