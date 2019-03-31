import {Component, ChangeDetectorRef, AfterViewInit, Pipe} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry, MatDialog } from '@angular/material';
import { TdMediaService, tdRotateAnimation } from '@covalent/core';
import {CategoryService,Category} from "./category.service";
import {Event,EventService} from "./event.service";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [tdRotateAnimation],
})
export class AppComponent implements AfterViewInit {

  navLinks=[
      {path:'categories',label:'Categories'},
      {path:'events',label:'Events'},
      {path:'times',label:'Times'}
  ];


  constructor(
    public media: TdMediaService,
    public dialog: MatDialog,
    private _changeDetectorRef: ChangeDetectorRef,
    private _iconRegistry: MatIconRegistry,
    private _domSanitizer: DomSanitizer
  )
  {
    this._iconRegistry.addSvgIconInNamespace(
      'assets',
      'covalent',
      this._domSanitizer.bypassSecurityTrustResourceUrl(
        'https://raw.githubusercontent.com/Teradata/covalent-quickstart/develop/src/assets/icons/covalent.svg',
      ),
    );

  }

  ngAfterViewInit(): void {
    // broadcast to all listener observables when loading the page
    this.media.broadcast();
    this._changeDetectorRef.detectChanges();
  }

}
