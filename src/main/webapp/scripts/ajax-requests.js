/*
    This code will use your servlets to render reimbursement date.
    You should not change the contents of this file.
*/

function ajaxGetRequest(url, callback){
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4 && xhr.status===200){
            callback(JSON.parse(xhr.response));
        }
    }
    xhr.send();
}
