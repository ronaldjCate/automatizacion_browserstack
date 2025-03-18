Feature: Búsqueda en Wikipedia

  @CASO_PRUEBA_1
  Scenario Outline: El usuario busca información en Wikipedia
    Given que el usuario abre la aplicación Wikipedia
    When busca el término "<textoBuscar>"
    Then debería ver resultados de búsqueda
    Examples:
      |textoBuscar  |
    |BrowserStack |
