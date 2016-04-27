

angular.module('zooKeeperApp').controller('foodCtrl', [
		'$scope', 'toaster', 'foodFactory',
		function ($scope,toaster, foodFactory) {
'use strict';		

			$scope.foodName = "";
			$scope.foodVendor = "";
			$scope.selectedCategory = null;
			$scope.reverse = false;
		    $scope.formVisible = false;
		    $scope.updateFormVisible = false;
		    $scope.isUpdate = false;
		    $scope.showUpdateBtn = false;
		    $scope.currentPage = 1;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 10;
		
		//get a list of foods
		foodFactory.getFoodList().then(function(success){
			$scope.foodList = success.data;
			$scope.totalItems = success.data.length;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		//get a list of food category
		foodFactory.getFoodCategory().then(function(success){
			$scope.foodCategoryList = success.data;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		
		
		//update a selected food
		$scope.updateFood = function(food){
			foodFactory.updateFood(food).then(function(success){
				toaster.pop('success', "Selected food has been updated");
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add a new food
		$scope.createFood = function(){
			var food = {};
			food.foodCategory = {};
			
			food.name = $scope.foodName.replace(/</g, "&lt").replace(/>/g, "&gt");
			food.vendor = $scope.foodVendor.replace(/</g, "&lt").replace(/>/g, "&gt");
			food.foodCategory = $scope.selectedCategory;
			
			foodFactory.addFood(food).then(function(success){
				toaster.pop('success', "New food has been added");
				foodFactory.getFoodList().then(function(success){
					$scope.foodList = success.data;

				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.foodName = "";
			$scope.foodVendor = "";
			$scope.selectedCategory = null;
			form.$setUntouched();
		}
		
		
		$scope.orderBy = function ( orderProp ) {
			$scope.reverse = ( $scope.orderProp === orderProp ) ? !$scope.reverse : true;
			$scope.orderProp = orderProp;
		}
		
		$scope.enableUpdate = function() {
			$scope.updateFormVisible = true; 
			$scope.isUpdate = true; 
			$scope.showUpdateBtn = true;
		}
		
		$scope.disableUpdate = function() {
			$scope.updateFormVisible = false; 
			$scope.isUpdate = false; 
			$scope.showUpdateBtn = false;
		}
}])