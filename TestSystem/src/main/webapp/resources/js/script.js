function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight) + "px";
}

var questionNumber = -1;
var answerNumber = 0;
$(function () {
    $("#createQuestion").click(function () {
        var html2Add =
            "<input hidden value='" + questionNumber++ + "'/>" +
            "<div id='question[" + questionNumber + "]' class='question'>" +
                "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
                "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
                "<input hidden name='questions[" + questionNumber + "].number' value='" + questionNumber + "'/>" +
                "<h4>Вопрос № " + (questionNumber + 1) +
                    "<input type='button' id='rem_id"+questionNumber+"' class='removeQuestion' value='-'/>"+
                "</h4>" +
                    "<div class='answers' id='answers[" + questionNumber + "]'>" +
                        "<textarea placeholder='question' name='questions[" + questionNumber + "].text' maxlength='255' required/><br>" +
                        "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
                        "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
                        "<input hidden type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].right'/>" +
                        "<label id='label_id" + answerNumber + "' for='answer_id" + answerNumber + "'></label>" +
                        "<input type='text' id='text_id" + answerNumber + "' placeholder='answer' name='answers[" + answerNumber + "].answerText' maxlength='100' required/>" +
                        "<input hidden value='"+answerNumber++ +"'/>"+
                    "</div>" +
                "<input type='button' id='" + questionNumber + "' class='createAnswer' value ='" + document.getElementById("button.addAnswer").value + "'/><br>" +
            "</div>";
        $('.questionBlock').prepend(html2Add);
    })
});

$(function () {
    console.log("answer number before adding: "+answerNumber);
    $(".questionBlock").on("click", ".createAnswer", function () {
        var html2Add =
            "<div id='div_id" + answerNumber + "'>" +
            "<input hidden name='answers[" + answerNumber + "].questionNumber' value='" + questionNumber + "'>" +
            "<input hidden name='answers[" + answerNumber + "].answerNumber' value='" + answerNumber + "'/>" +
            "<input hidden type='checkbox' id='answer_id" + answerNumber + "' name='answers[" + answerNumber + "].right'/>" +
            "<label id='label_id" + answerNumber + "' for='answer_id" + answerNumber + "'></label>" +
            "<input type='text' id='text_id" + answerNumber + "' placeholder='answer' name='answers[" + answerNumber + "].answerText' maxlength='100' required/>" +
            "<input type='button' id='" + answerNumber + "' class='removeAnswer' value='-'><br>" +
            "<input hidden value='"+answerNumber++ +"'/>"+
            "</div>";
        var questionId = $(this).attr("id");
        var element = document.getElementById("answers[" + questionId + "]");
        console.log("questionId: "+questionId);
        $(element).append(html2Add);
        console.log("appended to element: "+element);
    });
});

$(function () {
    $(".questionBlock").on("click", ".removeAnswer", function () {
        var currentAnswerId = $(this).attr("id");
        var div2Delete = document.getElementById("div_id" + currentAnswerId);
        if($(div2Delete).remove()) {
            answerNumber--;
        }
    })
});

$(function () {
    $(".questionBlock").on("click", ".removeQuestion", function () {
        var currentEl = $(this).attr("id");
        console.log("current el "+currentEl);
        var currentQuestionId = currentEl.replace('rem_id','');
        console.log("currentQuestionId: "+currentQuestionId);
        var div2Delete = document.getElementById("question[" + currentQuestionId+"]");
        console.log("div to delete: "+$(div2Delete).attr("id"));
        if($(div2Delete).remove()) {
            questionNumber--;
            answerNumber--;
            console.log("removed. Question number: "+questionNumber);
        }
    })
});

var index=0;

$(function () {
    $(".test").on("click", ".answerRadio", function () {
        var element = $(this);
        var ansId = $(this).attr("id");
        var questId = $(this).val();
        var num = ansId.replace('radio_','');
        var html2add="<input hidden name='radioAns["+ index +"].answerId' value='"+num+"'/>" +
            "<input hidden name='radioAns["+ index +"].questionId' value='"+questId+"'";
        $(".question").append(html2add);
        index++;
    })
});

// $(function () {
//     $(".test").on("click", ".answerCheckbox", function () {
//         var element = $(this);
//         var ansId = $(this).attr("id");
//         var num = ansId.replace('check_','');
//         var html2add="<input hidden name='radioAns["+ ++index +"]' value='"+num+"'/>";
//         $(".question").append(html2add);
//     })
// });


// $(function () {
//     $(".test").on('click',".answerRadio",function () {
//         var element = $(this);
//         var ansId = $(this).attr("id");
//         var num = ansId.replace('radio_','');
//         console.log("num : "+num);
//         if(array.indexOf(num) == -1){
//             array.slice(array.indexOf(num),1);
//         }else{
//             array.push(num);
//         }
//
//         $("#idList").val(array);
//     })
//     $(".test").on('click',".answerCheckbox",function () {
//         var element = $(this);
//         var ansId = $(this).attr("id");
//         var num = ansId.replace('radio_','');
//         console.log("num : "+num);
//         if(array.indexOf(num) == -1){
//             array.slice(array.indexOf(num),1);
//         }else{
//             array.push(num);
//         }
//
//         $("#idList").val(array);
//     })
//
//
//
// });

