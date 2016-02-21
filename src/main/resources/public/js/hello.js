/**
 * Created by piotr on 18.02.16.
 */
angular.module('hello',[]).controller("home",
function($scope,$http){
    $http.get("http://localhost:8080/user")
        .then(function(response) {
            $scope.user = response;
        });
});