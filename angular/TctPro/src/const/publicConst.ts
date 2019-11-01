export const RESULT ={

    MESSAGE_KEY: "message",
    STATUS_KEY: "status",
    DATA_KEY:'data',
    ID_KEY:'id',
    RESULT_KEY:'result',
    TOTALSIZE_KEY:'totalSize',
    GET_MASSAGE_CODE:(data:string):number=>{
        let split_data:string[]  = data.split(":");
        return Number(split_data[0]);
    },
    GET_MASSAGE_CONTEXT:(data:string):string=>{
        let split_data:string[]  = data.split(":");
        return split_data[1].toString();
    },
    WORKS_SAVE_CODE:{
        ARTIST_NOT_EXIST:201111
    }

}