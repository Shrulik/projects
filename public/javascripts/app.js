var app = angular.module("Projects",['ngRoute', 'ngGrid']);

app.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider ) {


   $routeProvider.when('/', {
        templateUrl: '/assets/ng/partials/projects.html',
        controller: 'ProjectsCtrl'
      }).when('/project/:projectId', {
            redirectTo:'/'
      }).otherwise({
        redirectTo: '/'
      });

//  $locationProvider.html5mode(true);
  }]);

