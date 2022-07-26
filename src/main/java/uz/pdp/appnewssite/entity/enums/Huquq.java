package uz.pdp.appnewssite.entity.enums;

public enum Huquq {
    ADD_USER, //ADMIN                  //ADMIN tomondan User qushish
    EDIT_USER, //ADMIN                  //boshqa tomondan edit qilinishi
    DELETE_USER,//ADMIN
    VIEW_USERS,//ADMIN
    ADD_LAVOZIM,//ADMIN
    EDIT_LAVOZIM,//ADMIN
    DELETE_LAVOZIM,//ADMIN
    VIEW_LAVOZIMLAR,//ADMIN          //Mana shu ergacha tizimda bogliq bo'ganlari
    ADD_POST,  //ADMIN ...              //Tizimdan tashqarida Baholash
    EDIT_POST, //ADMIN ...               //VIEW_POST yozish shart emas hamma uchun ochiq maqolani
    DELETE_POST, //ADMIN ...           // ko'rish uchun registratsiysadan utish shart emas
    ADD_COMMENT, //ALL
    EDIT_COMMENT,//ALL
    DELETE_MY_COMMENT,//ALL
    DELETE_COMMENT,//ADMIN ...
}
