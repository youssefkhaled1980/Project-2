/*
    This code will use your servlets to render reimbursement date.
    You should not change the contents of this file.
*/

window.onload = function () {
    // initially load all reimbursements
    ajaxGetReimbursements();

    // set up event listeners for buttons
    if (document.getElementById("all-btn")) {
        document.getElementById("all-btn").addEventListener("click", populateAll);
        document.getElementById("pending-btn").addEventListener("click", populatePending);
        document.getElementById("approved-btn").addEventListener("click", populateApproved);
        document.getElementById("denied-btn").addEventListener("click", populateDenied);
    }

    // fetch reimbursement data based on status, render table with data
    function ajaxGetReimbursements(status) {
        let requestUrl = "http://localhost:8444/all_reimbursements"
        if (status) {
            requestUrl = requestUrl + "?status=" + status;
        }
        ajaxGetRequest(requestUrl, renderTable);
    }

    // clear table and fetch all reimbursement data regardless of status
    function populateAll() {
        clearTable();
        ajaxGetReimbursements();
    }

    // clear table and fetch approved reimbursement data
    function populateApproved() {
        clearTable();
        ajaxGetReimbursements("APPROVED");
    }

    // clear table and fetch denied reimbursement data
    function populateDenied() {
        clearTable();
        ajaxGetReimbursements("DENIED");
    }

    // clear table and fetch pending reimbursement data
    function populatePending() {
        clearTable();
        ajaxGetReimbursements("PENDING");
    }

}


