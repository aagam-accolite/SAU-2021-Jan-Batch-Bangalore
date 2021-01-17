
export class SessionModel{
    id?: number;
    name : string;
    trainer : string;
    date : Date;
    isDisplay?:boolean;
    constructor(){
        this.id = Math.random();
        this.name = '';
        this.trainer = '';
        this.date = new Date();
        this.isDisplay = false;
    }
}