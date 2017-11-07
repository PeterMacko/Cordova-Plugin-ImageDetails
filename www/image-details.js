function ImageDetails() {
}

ImageDetails.prototype.resolution = function(filePath, sucess, failure) {
	var args = {};
	args.filePath = filePath;
	return new Promise((resolve,reject) => {
		cordova.exec(resolve, reject, "ImageDetails", "resolution", [args]);
	});
}

cordova.addConstructor(function()  {
	if(!window.plugins)
	{
		window.plugins = {};
	}
	
   // shim to work in 1.5 and 1.6
   if (!window.Cordova) {
   	window.Cordova = cordova;
   };
   
   window.plugins.ImageDetails = new ImageDetails();
});
