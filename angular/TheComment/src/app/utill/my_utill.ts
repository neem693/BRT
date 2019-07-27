import { DateAdapter } from '@angular/material';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { Moment } from 'moment';



export const KoreaDateFormat = {
    parse: {
        dateInput: 'YYYYMMDD'
    }, 
    display: {
        dateInput: 'YYYY년MM월DD일',
        monthYearLabel: 'YYYY년MM월',
        dateA11yLabel: 'YYYY년MM월DD일',
        monthYearA11yLabel: 'YYYY년MM월'
    }
}; 


export class customDateAdapter extends MomentDateAdapter{
   

    format(date: Moment, displayFormat: string): string{
        console.log(date);
        console.log("작동 중 모멘트 어뎁터");
        return date.format('YYYY년MM월DD일');
    };

  


}
