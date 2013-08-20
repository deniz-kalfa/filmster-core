package filmster.types

enum View {
  HOMEPAGE('index'),
  STATUS_SHOW('status/show')

  private String viewName

  View(String viewName) {
    this.viewName = viewName
  }

  String getViewName() {
    viewName
  }
}