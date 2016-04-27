

angular.module('zooKeeperApp').config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
'use strict';

    $urlRouterProvider.otherwise('home');

    $stateProvider.state('foodpage', {

        url: '/foods',
        templateUrl: 'templates/food.tpl.html',
        controller: 'foodCtrl',
        
    }).state('home', {
    	url:'/home',
    	templateUrl: 'templates/home.tpl.html',
    	controller: 'homeCtrl',
    
    }).state('speciespage', {
    	url: '/species',
    	templateUrl: 'templates/species.tpl.html',
    	controller: 'speciesCtrl',
    
    }).state('animalpage', {
    	url: '/animal',
    	templateUrl: 'templates/animal.tpl.html',
    	controller: 'animalCtrl',
    
    }).state('enclosurepage', {
    	url: '/enclosure',
    	templateUrl: 'templates/enclosure.tpl.html',
    	controller: 'enclosureCtrl'
    });
    
    
}]);