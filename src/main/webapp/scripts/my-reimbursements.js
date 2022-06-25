/*
    This code will use your servlets to render reimbursement date.
    You should not change the contents of this file.
*/

window.onload = function () {

    // initially fetch employees and render them in the dropdown
    ajaxGetEmployees()

    // request employee data (non manager data)
    function ajaxGetEmployees() {
        let requestUrl = "http://localhost:8080/ExpenseReimbursementSystem/employees?isManager=false"; //create employeebyid (get all employees that are not managers)
        const xhr = new XMLHttpRequest();
        ajaxGetRequest(requestUrl, populateDropdown)
    }

    // render select options
    function populateDropdown(employees) {
        const employeeSelect = document.getElementById("employee-select");
        for (let employee of employees) {
            const opt = document.createElement("option");
            opt.value = employee.id;
            opt.innerHTML = employee.first + " " + employee.last;
            employeeSelect.appendChild(opt);
        }
        employeeSelect.addEventListener("change", populateReimbursements);
    }

    // use select input to populate reimbursements for the chosen employee
    function populateReimbursements(e) {
        const id = e.target.value;
        ajaxGetReimbursementsByEmployee(id);
    }

    function ajaxGetReimbursementsByEmployee(employeeId) {
        let requestUrl = `http://localhost:8080/ExpenseReimbursementSystem/employees/${employeeId}/reimbursements`
        ajaxGetRequest(requestUrl, renderTable)
    }


}