import org.scalatest.Checkpoints.Checkpoint

def withCheckPoint[A](seq: Seq[A])(f: A => Any): Unit = {
  val cp = new Checkpoint
  seq.foreach(x => cp(f(x)))
  cp.reportAll()
}
