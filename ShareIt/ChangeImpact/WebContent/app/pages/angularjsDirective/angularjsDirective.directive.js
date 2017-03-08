/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('ChangeImpact.pages')
      .directive('angularjsDirective', angularjsDirective);

  /** @ngInject */ 
  function angularjsDirective() {
    return {
      restrict: 'E',
      controller: 'angularjsDirectiveCtrl',
      templateUrl: 'app/pages/angularjsDirective/angularjsDirective.html'
    };
  }
})();