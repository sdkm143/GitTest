/**
 * @author a.demeshko
 * created on 24/12/15
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages') 
    .controller('angularjsDirectiveCtrl', angularjsDirectiveCtrl);

  /** @ngInject */
  function angularjsDirectiveCtrl($http, $scope) {
/*    var vm = this; 
    vm.firstName = "John";
    vm.lastName = "Deo";*/
    
    $scope.firstName= "John";
    $scope.lastName= "Doe";

    $http.get("./rest/jsonServices/getTestcaseName/").success(function (response) {
		 
 		$scope.testcaseName = response;	
 	 
   }); 
  }
})();