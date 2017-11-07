/*global cordova, module*/

module.exports = {
    resolution: function (fileName, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ImageDetails", "resolution", [fileName]);
    }
};
