Feature: Projects

  Background: Jira page is loaded and user logged in
    Given PRJ Jira page is loaded

  Scenario: PROJ1: Verificar que el sistema permite la creacion de proyectos Scrum clasicos
    Given PRJ User is logged in
    And PRJ Click en dropdown "Create project" localizado el la parte de arriba a la derecha de la pagina
    And PRJ Seleccionar el drop down item "Classic project"
    And PRJ Click en el boton "Change template"
    And PRJ Click en el boton "Select" de la tarjeta con el nombre "Scrum"
    And PRJ Editar el campo "Name" con el valor "PROJ:ProyectoClassicScrum1"
    And PRJ Click en el boton "Create"
    Then PRJ Se muestra la pagina del proyecto con el nombre "PROJ:ProyectoClassicScrum1" seleccionado en el menu lateral izquierdo

  Scenario: PROJ2: Verificar que el sistema permite la creacion de proyectos Kanban clasicos
    Given PRJ Click en dropdown "Create project" localizado el la parte de arriba a la derecha de la pagina
    And PRJ Seleccionar el drop down item "Classic project"
    And PRJ Click en el boton "Change template"
    And PRJ Click en el boton "Select" de la tarjeta con el nombre "Kanban"
    And PRJ Editar el campo "Name" con el valor "PROJ:ProyectoClassicKanban1"
    And PRJ Click en el boton "Create"
    Then PRJ Se muestra la pagina del proyecto con el nombre "PROJ:ProyectoClassicKanban1" seleccionado en el menu lateral izquierdo

  Scenario: PROJ3: Verificar que el sistema lista los proyectos creados por el usuario
    Given: PRJ Click en el link "Projects" del menu lateral izquierdo
    Then PRJ El proyecto "PROJ:ProyectoClassicScrum1" debe estar en la lista de proyectos

  Scenario: PROJ4: Verificar que el sistema permite configurar el campo "Name" de un proyecto creado
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrum1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo "Name" del proyecto creado y cambiarlo a "PROJ:ProyectoClassicScrumModified1"
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And PRJ Click en el breadcrumb item "Projects"
    Then PRJ Verificar que el el campo "Name" del proyecto "PROJ:ProyectoClassicScrumModified1" cambio a "PROJ:ProyectoClassicScrumModified1"

  Scenario: PROJ5: Verificar que el sistema permite configurar el campo "Key" de un proyecto creado
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo "Key" del proyecto creado y cambiarlo a "PROJMOD1"
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And PRJ Click en el breadcrumb item "Projects"
    Then PRJ Verificar que el el campo "Key" del proyecto "PROJ:ProyectoClassicScrumModified1" cambio a "PROJMOD1"

  Scenario: PROJ6: Verificar que el sistema permite configurar el campo "URL" de un proyecto creado
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo "URL" del proyecto creado y cambiarlo a "http://ProyectoClassicScrumModificado1"
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And PRJ Click en el breadcrumb item "Projects"
    Then PRJ Verificar que el el campo "URL" del proyecto "PROJ:ProyectoClassicScrumModified1" cambio a "http://ProyectoClassicScrumModificado1"

  Scenario: PROJ7: Verificar que el sistema permite configurar el campo "Description" de un proyecto creado
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo 'Description' del proyecto creado y cambiarlo a "PROJ:Description"
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And PRJ Click en el breadcrumb item "Project settings"
    Then PRJ Verificar que el el campo "Description" del proyecto "PROJ:ProyectoClassicScrumModified1" cambio a "PROJ:Description" in the project settings page

  Scenario: PROJ8: Verificar que el sistema permita configurar el campo "Default Assignee" de un proyecto creado
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Click en el dropdown "Default Assignee" and click en el dropdown item "Project Lead"
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And PRJ Click en el breadcrumb item "Project settings"
    Then PRJ Verificar que el el campo "Default Assignee" del proyecto "PROJ:ProyectoClassicScrumModified1" cambio a "Project Lead" in the project settings page

  Scenario: PROJ9: Verificar que el sistema muestra un mensaje de error cuando se modifica el 'nombre' del proyecto a una cadena vacia
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo "Name" del proyecto creado y cambiarlo a ""
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    Then PRJ Verificar que el mensaje de error "You must specify a valid project name" es mostrado para el campo "Name"

  Scenario: PROJ10: Verificar que el sistema muestra un mensaje de error cuando se modifica el 'key' del proyecto a una cadena vacia
    Given PRJ Click en el link "Projects" del menu lateral izquierdo
    And PRJ Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And PRJ Seleccionar el dropdown item "Project settings"
    And PRJ Editar el campo "Key" del proyecto creado y cambiarlo a " "
    And PRJ Click en el boton "Save details" ubicada en la parte inferior de la pagina
    Then PRJ Verificar que el mensaje de error "Project keys must start with an uppercase letter, followed by one or more uppercase alphanumeric characters" es mostrado para el campo "Key"
