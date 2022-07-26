const flag1 = true;
const flag2 = false;
if (flag1) {
    // 1st path
} else if (flag2) {
    // 2nd path
} else {
    // 3rd path
}
function a(x) {
    if (true) {
        return x;
    } else if (false) {
        return x+1;
    } else {
        return 4; // 3rd path
    }
}

function b() {
    foo ||= 1;
    bar &&= 1;
}