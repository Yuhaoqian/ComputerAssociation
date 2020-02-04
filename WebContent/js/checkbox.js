$(function () {
    $('#chkAll').on('click',function () {
        $('.chks').prop('checked',$(this).prop('checked'));
    });
});