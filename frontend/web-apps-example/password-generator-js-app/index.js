const passwordBox = document.getElementById("password")
const length = 12;

function createPassword(){
    const password = generatePassword(12);
    passwordBox.value = password
}

function copyPassword(){
    passwordBox.select();
    document.execCommand("copy")
}

function generatePassword(length) {
    const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    let retVal = "";
    for (var i = 0, n = charset.length; i < length; ++i) {
        retVal += charset.charAt(Math.floor(Math.random() * n));
    }
    return retVal;
}
