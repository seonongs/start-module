function getCode(groupCode) {

    $.ajax({
        url: "/code"
        , type: "post"
        // , contentType:"application/json; charset=utf-8"
        , data: {groupCode: groupCode}

        , success: function (data) {
            console.log(data)

            let result = "<select className=\"form-select\" aria-label=\"Default select example\">"
            result += "<option selected>선택</option>"

            for (let i = 0; i < data.length ; i++) {

                result += "<option value='" +  data[i].code + "'>" + data[i].codeName  +  "</option>"

            }
            result += "</select>"

            console.log(result)

            document.getElementById(groupCode).value = result
        }
    });

}

// <select className="form-select" aria-label="Default select example"><option selected>선택</option><option value=admin>undefined/option><option value=user>undefined/option></select>















