Feature: Projects

  Background: Jira page is loaded and user logged in
    Given Jira page is loaded

  Scenario: PROJ1: Verificar que el sistema permite la creacion de proyectos Scrum clasicos
    Given User is logged in
    And PROJ: Click en drop down 'Create project' localizado el la parte de arriba a la derecha de la pagina
    And Click en el boton "Change template"
    And Click en el boton "Select" de la tarjeta con el nombre "Scrum"
    And Editar el campo "Name" con el valor "PROJ:ProyectoClassicScrum1"
    And Click en el boton "Create"
    Then Se muestra la pagina del proyecto con el nombre "PROJ:ProyectoClassicScrum1" seleccionado en el menu lateral izquierdo

  Scenario: PROJ2: Verificar que el sistema permite la creacion de proyectos Kanban clasicos
    Given PROJ: Click en drop down 'Create project' localizado el la parte de arriba a la derecha de la pagina
    And Seleccionar el drop down item "Classic project"
    And Click en el boton "Change template"
    And Click en el boton "Select" de la tarjeta con el nombre "Kanban"
    And Editar el campo "Name" con el valor "PROJ:ProyectoClassicKanban1"
    And Click en el boton "Create"
    Then Se muestra la pagina del proyecto con el nombre "PROJ:ProyectoClassicKanban1" seleccionado en el menu lateral izquierdo

  Scenario: PROJ3: Verificar que el sistema lista los proyectos creados por el usuario
    Given: Click en el link "Projects" del menu lateral izquierdo
    Then El proyecto "PROJ:ProyectoClassicScrum1" debe estar en la lista de proyectos

  Scenario: PROJ4: Verificar que el sistema permite configurar el campo "Name" de un proyecto creado
    Given Click en el link "Projects" del menu lateral izquierdo
    And Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrum1"
    And Seleccionar el dropdown item "Project settings"
    And Editar el campo "Name" del proyecto creado y cambiarlo a "PROJ:ProyectoClassicScrumModified1"
    And Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And Click en el breadcrumb item "Projects"
    Then Verificar que el el campo 'Name' del proyecto creado cambio a "PROJ:ProyectoClassicScrumModified1"

  Scenario: PROJ4: Verificar que el sistema permite configurar el campo "Key" de un proyecto creado
    Given Click en el link "Projects" del menu lateral izquierdo
    And Click en el dropdown "More" en la tabla de proyectos para el proyecto "PROJ:ProyectoClassicScrumModified1"
    And Seleccionar el dropdown item "Project settings"
    And Editar el campo "Key" del proyecto creado y cambiarlo a "PROJMOD1"
    And Click en el boton "Save details" ubicada en la parte inferior de la pagina
    And Click en el breadcrumb item "Projects"
    Then Verificar que el el campo 'Key' del proyecto creado cambio a "PROJMOD1"
