function handleFiles(obj,id) 
{ file = document.getElementById("icon"); 
var files = obj.files; 
img = new Image(); 
if(window.URL){ 
img.src = window.URL.createObjectURL(files[0]); //����һ��object URL����������ı���·��
img.onload = function(e) 
{ window.URL.revokeObjectURL(this.src); //ͼƬ���غ��ͷ�object URL 
} }
file.src=img.src; //�ϴ��ļ� 
var fd = new FormData(),//ʵ����һ���� 
xhr = new XMLHttpRequest();fd.append('headimg', files[0]);//׷��ͼƬԪ�� 
xhr.open('post', 'user.php?act=act_edit_img');//����ʽ�������ַ xhr.send(fd);
}
