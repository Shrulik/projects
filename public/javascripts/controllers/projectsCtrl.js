app.controller('ProjectsCtrl',['$scope','$http', function ( $scope, $http ) {

   $scope.gridOptions = { data: 'projects', multiSelect: false };

   $scope.toggleDesc = function (project) {
       project.show = !project.show;
   }


    $scope.newProject = {};
    $scope.addProject = function () {
        $scope.newProject.votes = 0;

        $http.put('/project', $scope.newProject).success(function (project) {
            $scope.projects.push(project);
            $scope.newProject = {};
        }).error(function (errors) {
                $scope.info=errors;
            })
        

    }
    $scope.upVote = function (project) {
        project.votes++;
        $http.post("/project/" + project.id, project).success(function (resp) {
            console.log(resp);
        }).error(function(error){
            console.log(error);
            });
    }
    $http.get("/project").success( function ( projects) {
            $scope.projects = projects;
            console.log($scope.projects);
            console.log($scope);
        }  );

}  ]);