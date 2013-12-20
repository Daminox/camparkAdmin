/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateCrop(img, selection)
{
    var parent = $(img).parent();
    parent.find('input[class="x1"]').val(selection.x1);
    parent.find('input[class="y1"]').val(selection.y1);
    parent.find('input[class="x2"]').val(selection.x2);
    parent.find('input[class="y2"]').val(selection.y2);
}

function consruireCropArea(j)
{
    var div = jQuery('<div>', {
        'style': 'float:left;',
        'id': 'croppable_' + j
    });

    var img = jQuery('<img>', {
        'class': 'cropppable imgToReduce'
    });
    var ref = $('#imgReferenceRaw');
    var red = $("#selectReduction").val();
    img.width( ($('#imgReferenceRaw').get(0).width / red));
    img.attr('src', ref.attr('src'));
    img.imgAreaSelect({
        handles: true,
        onSelectEnd: validateCrop
    });

    div.append(img);
    var div2 = jQuery('<div>', {
        'style': 'text-align:center'
    });
    var outputx1 = jQuery('<input>',
            {
                'class': 'x1',
                'name': 'x1_' + j,
                'disabled': 'disabled'
            });
    var outputx2 = jQuery('<input>',
            {
                'class': 'x2',
                'name': 'x2_' + j,
                'disabled': 'disabled'
            });
    var outputy1 = jQuery('<input>',
            {
                'class': 'y1',
                'name': 'y1_' + j,
                'disabled': 'disabled'
            });
    var outputy2 = jQuery('<input>',
            {
                'class': 'y2',
                'name': 'y2_' + j,
                'disabled': 'disabled'
            });
    var lat = jQuery('<input>',
            {
                'class': 'lat',
                'name': 'lat_' + j
            });
    var long = jQuery('<input>',
            {
                'class': 'long',
                'name': 'long_' + j
            });
    div2.append('Lat : ').append(lat).append('Long : ').append(long);
    div2.append('<br/>X1');
    div2.append(outputx1);
    div2.append('Y1');
    div2.append(outputy1);
    div2.append('<br/>X2');
    div2.append(outputx2);
    div2.append('Y2');
    div2.append(outputy2);
    div.append(div2);
    return div;
}


function afficherImage(inputNbPlace, areaToDisplay)
{
    var nbCropTodo = inputNbPlace.val();
    areaToDisplay.html('');
    for (var i = 1; i <= nbCropTodo; ++i)
    {
        areaToDisplay.append(consruireCropArea(i));
    }
    return false;
}
