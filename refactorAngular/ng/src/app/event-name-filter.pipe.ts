import { Pipe, PipeTransform } from '@angular/core';
import {Event} from "./event.service";

@Pipe({
  name: 'eventNameFilter'
})
export class EventNameFilterPipe implements PipeTransform {

  transform(events:Event[], nameEvents: string): Event[] {
    if(nameEvents==null || nameEvents ===""){
    return events;
    }
    return events.filter(e=>e.nameEvent.includes(nameEvents)|| e.date.includes(nameEvents) || e.location.includes(nameEvents) || e.wiki.includes(nameEvents));
  }

}
