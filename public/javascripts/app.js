var app = angular.module("Projects", []);

app.controller('SimpleCtrl', ['$scope', 'Project', function ($scope, Project) {

    $scope.ourTitle = "Projects";

    $scope.toggleDesc = function (project) {
        project.show = !project.show;
    }

    $scope.projects = Project.query();


}]);


app.service('Project', ['$http', function ($http) {

    return {
        query: function () {
            return $http.get("/project").then(function (response) {
                return response.data;
            });
        }
    }
}  ]);