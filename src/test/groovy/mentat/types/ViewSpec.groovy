package filmster.types

import spock.lang.Specification

class ViewSpec extends Specification {

  def 'views enum has correct view names'() {
    expect:
      view.viewName == viewName

    where:
      view             | viewName
      View.STATUS_SHOW | 'status/show'
      View.HOMEPAGE    | 'index'
  }
}
