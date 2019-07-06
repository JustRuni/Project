function request(method,url,data,successFunction,errorFunction){
    $.ajax({
        url: url,
        async:true,
        contentType: "application/json",
        data: JSON.stringify(data),
        method: method,
        success: successFunction,
        error:errorFunction
    });
} 