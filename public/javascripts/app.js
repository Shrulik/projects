var app = angular.module("Projects", []);

app.controller('SimpleCtrl', ['$scope', 'Project', function ($scope, Project) {

    $scope.ourTitle = "Projects";
    $scope.projects = Project.query();
    $scope.newProject = {};

    $scope.addProject = function () {
        $scope.newProject.votes = 0;

        Project.insert($scope.newProject, function (project) {
            $scope.projects.then(function (projects) {
                projects.push(project);
            });
            $scope.newProject = {};
        },function (errors) {
            $scope.messages = errors;
        });

    }

    $scope.toggleDesc = function (project) {
        project.show = !project.show;
    };
}]);


app.service('Project', ['$http', function ($http) {

    return {
        query: function () {
            return $http.get("/project").then(function (response) {
                return response.data;
            });
        },

        insert: function (project, successCallback, errorCallback) {

            $http.post('/project', project).
                success(successCallback).error(errorCallback)

        }
    }
}  ]);