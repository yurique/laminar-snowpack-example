package io.laminext.syntax

import com.raquo.laminar.api.L._

package object all {

  implicit def syntaxObservable[A](s: Observable[A]): ObservableOps[A] = new ObservableOps[A](s)

}
