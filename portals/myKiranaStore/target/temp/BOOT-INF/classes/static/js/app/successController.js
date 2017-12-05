'use strict';

angular.module('kiranaApp').controller('tnxSuccessCtrl',
    ['$scope','$state',  function($scope,$state) {
    	
      $scope.cust = $state.params.customer;
      $scope.order = $state.params.order;
      $scope.cartItems = $state.params.cart;
      
      if($scope.order == null)
 		 $state.go('home');  
      
      $scope.tnxId = $state.params.invoice != null ? $state.params.invoice.tnxId : '1';	

    }]);