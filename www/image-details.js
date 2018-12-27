ImageDetails = function () {};

ImageDetails.prototype.resolution = function(filePath, sucess, failure) {
	var args = {};
	args.filePath = filePath;
	return new Promise(function (resolve,reject) {
		cordova.exec(resolve, reject, "ImageDetails", "resolution", [args]);
	});
};

var imageDetails = new ImageDetails();
module.exports = imageDetails;