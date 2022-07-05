//create Table
function CreateTable() {
    var table = document.createElement('table');

//create Table Header
    var header = ['dd.mm.yyyy', 'day of week'];
    var tr = document.createElement('tr');
    for (var column in header) {
        var th = document.createElement('th');
        th.innerHTML = header[column];
        tr.appendChild(th)
    }
    table.appendChild(tr);

//create Table Body

    var month = new Date().getMonth()+1;
    const date = new Date();

    var input = [
        [date.getDate()+"."+month+"."+date.getFullYear(), date.getDay()]
    ];
    var tempDate = new Date();

    for(let i=1; i < 7; i++){
        tempDate.setDate(tempDate.getDate()+1);
        input.push([tempDate.getDate()+"."+month+"."+ date.getFullYear(), tempDate.getDay()]);
    }


    for (var row in input) {
        var tr = document.createElement('tr');
        for (var column in input[row]) {
            var td = document.createElement('td');
            td.innerHTML = input[row][column];
            tr.appendChild(td)
        }
        table.appendChild(tr);
    }

// append Table
    document.body.appendChild(table);
}
