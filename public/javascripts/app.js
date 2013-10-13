var app = angular.module("Projects", ['ngRoute', 'ngGrid']);

app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {


//        $routeProvider.when('/simple', {
//            templateUrl: '/assets/ng/partials/simple.html'
//        }).when('/other/simple', {
//                templateUrl: '/assets/ng/partials/otherSimple.html'
//            }).otherwise({
//                redirectTo: '/'
//            });

        $routeProvider.when('/simple', {
            templateUrl: '/assets/ng/partials/simple.html'
        }).when('/other/simple', {
                templateUrl: '/assets/ng/partials/otherSimple.html'
            }).when('/binding', {
                controller: 'BindingCtrl',
                templateUrl: '/assets/ng/partials/binding.html'
            }).otherwise({
                redirectTo: '/'
            });

//        $routeProvider.when('/', {
//            templateUrl: '/assets/ng/partials/projects.html',
//            controller: 'ProjectsCtrl'
//        }).otherwise({
//                redirectTo: '/'
//            });

//  $locationProvider.html5mode(true);
    }]);

