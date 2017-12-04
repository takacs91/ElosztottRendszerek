<html lang="en" >
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Angular Material style sheet -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">
</head>
<body ng-app="MyApp" ng-cloak>
  <!--HTML content here-->  
  <md-content ng-controller="AppCtrl as ctrl" layout-padding="" ng-cloak="" class="datepickerdemoBasicUsage" ng-app="MyApp">
  <div layout-gt-xs="row">
    <div flex-gt-xs="">
      <h4>Standard date-picker</h4>
      <md-datepicker ng-model="ctrl.myDate" md-placeholder="Enter date"></md-datepicker>
    </div>

    <div flex-gt-xs="">
      <h4>Disabled date-picker</h4>
      <md-datepicker ng-model="ctrl.myDate" md-placeholder="Enter date" disabled=""></md-datepicker>
    </div>
  </div>

  <div layout-gt-xs="row">
    <div flex-gt-xs="">
      <h4>Opening the calendar when the input is focused</h4>
      <md-datepicker ng-model="ctrl.myDate" md-placeholder="Enter date" md-open-on-focus=""></md-datepicker>
    </div>

    <div flex-gt-xs="">
      <h4>Date-picker that goes straight to the year view</h4>
      <md-datepicker ng-model="ctrl.myDate" md-current-view="year" md-placeholder="Enter date"></md-datepicker>
    </div>
  </div>

  <div layout-gt-xs="row">
    <div flex-gt-xs="">
      <h4>Custom calendar trigger</h4>
      <md-datepicker ng-model="ctrl.myDate" md-placeholder="Enter date" md-is-open="ctrl.isOpen"></md-datepicker>
      <md-button class="md-primary md-raised" ng-click="ctrl.isOpen = true">Open</md-button>
    </div>
  </div>
</md-content>
  
  <!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
  
  <!-- Application bootstrap  -->
  <script type="text/javascript">    
  	angular.module('MyApp', ['ngMaterial', 'ngMessages']).controller('AppCtrl', function() {
	  this.myDate = new Date();
	  this.isOpen = false;
	});
  
    <!--angular.module('BlankApp', ['ngMaterial']);-->
  </script>
  
  
  
</body>
</html>
