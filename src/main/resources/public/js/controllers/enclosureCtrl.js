

angular.module('zooKeeperApp').controller('enclosureCtrl', [
		'$scope', 'toaster', 'enclosureFactory', 'animalFactory', 
		function ($scope, toaster, enclosureFactory, animalFactory) {
'use strict';

		$scope.enclosureName = "";
		$scope.startFeedTime = null;
		$scope.endFeedTime = null;
		$scope.enclosureCondition = "";
	    $scope.reverse = false;
	    $scope.formVisible = false;
	    $scope.updateFormVisible = false;
	    $scope.isUpdate = false;
	    $scope.showUpdateBtn = false;
	    $scope.inValidTime = false;
	    $scope.hstep = 1;
	    $scope.mstep = 1;
	    $scope.currentPage = 1;
		$scope.maxSize = 5;
		$scope.itemsPerPage = 10;
		$scope.searchBy = "";
		
		//get a list of enclosures
	    enclosureFactory.getEnclosureList().then(function(success){
			$scope.enclosureList = success.data;
			$scope.totalItems = success.data.length;
			
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
			
		
		//update a selected enclosure
		$scope.updateEnclosure = function(enclosure){
	    	
			enclosureFactory.updateEnclosure(enclosure).then(function(success){
				toaster.pop('success', "Selected enclosure has been updated")
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add an enclosure
		$scope.createEnclosure = function(){
			
			var enclosure = {};
			
			enclosure.name = $scope.enclosureName.replace(/</g, "&lt").replace(/>/g, "&gt");
			enclosure.startFeedTime = $scope.startFeedTime;
			enclosure.endFeedTime = $scope.endFeedTime;
			enclosure.condition = $scope.enclosureCondition.replace(/</g, "&lt").replace(/>/g, "&gt");
			enclosure.animalTotal = 0;
			
			enclosureFactory.addEnclosure(enclosure).then(function(success){
				toaster.pop('success', "New enclosure has been added" + $scope.endFeedTime);
				enclosureFactory.getEnclosureList().then(function(success){
					$scope.enclosureList = success.data;
					
				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//remove an enclosure
		$scope.removeEnclosure = function(id){
			
			enclosureFactory.deleteEnclosure(id).then(function(success){
				console.log(success);
				enclosureFactory.getEnclosureList().then(function(success){
						$scope.enclosureList = success.data;
						

					})
				toaster.pop('success', "Selected enclosure has been removed");
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
		}
		
		//get a list of animals based on selected enclosure id
		$scope.getAnimalByEnId = function(id){
			animalFactory.getAnimalByEnclosureId(id).then(function(success){
				$scope.enclosureAnimals = success.data;
			
			},function(error){
				
				toaster.pop('error', "Please try again later");
			})
		}
		
		//get a list of enclosure based on reside animal's favorite food
		$scope.searchEnclosureByFavFood = function(){
			enclosureFactory.getEnclosureByFavFood($scope.searchBy).then(function(success){
				$scope.enclosureList = success.data;
				$scope.searchBy = "";
			},function(error){
				toaster.pop('error', "Please try again later");
			})
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.enclosureName = "";
			$scope.startFeedTime = null;
			$scope.endFeedTime = null;
			$scope.enclosureCondition = "";
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
		
		$scope.validateTime = function(time1, time2) {
			$scope.inValidTime = time1.toLocaleTimeString() > time2.toLocaleTimeString();
			
			console.log($scope.inValidTime);
			console.log($scope.startFeedTime.toLocaleTimeString().sub);
			console.log($scope.endFeedTime.toLocaleTimeString());
		} 
		

}])