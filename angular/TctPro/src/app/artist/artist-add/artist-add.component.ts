import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { WorksAddComponent } from '../dialog/works-add/works-add-diaolog.component';
import { ArtistService } from '../artist.service';
import { ActivatedRoute, Router } from '@angular/router';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';

@Component({
  selector: 'app-artist-add',
  templateUrl: './artist-add.component.html',
  styleUrls: ['./artist-add.component.css']
})
export class ArtistAddComponent implements OnInit {

  artist = {
    artist_name: new FormControl("", [
      Validators.required
    ]),
    work_list: [],
  }

  constructor(
    private dialog: MatDialog,
    private artistService: ArtistService,
    private router: Router,
    private route: ActivatedRoute,
    private worksService:WorksSerivceService
  ) { }

  ngOnInit() {

    this.route.params.subscribe(x => {
      let data = {};
      data['id'] = x.id;
      this.worksSelectOneInitialize(data);
    })

  }

  addWorks() {

    let worksList = Object.assign([], this.artist.work_list);
    let dialogRef = this.dialog.open(WorksAddComponent, {

      data: { list: worksList },
      width: "80%"

    })

    dialogRef.afterClosed().subscribe((result) => {
      if (result == undefined || result == null) {
        return;
      }

      this.artist.work_list = result;

    })
  }

  artistSave() {
    console.log(this.artist);

    let artist_name_error = this.artist.artist_name.errors;
    if (artist_name_error != null) {
      return;
    }

    let data = {};
    data['artist_name'] = this.artist.artist_name.value;
    data['worksList'] = this.artist.work_list;

    this.artistService.artistSave(data).subscribe(x => {
      let data = x.body;
      let code = Number(data['result']);

      if (code == 200) {
        
        let id = data['id'];
        this.router.navigate(['/artist/artistSaveCheck', id]);

      } else if (code == 201) {

        let id = data['id'];
        this.router.navigate(['/artist/artistSaveCheck', id]);

      }
    });

  }

  worksSelectOneInitialize(data: any) {

    this.worksService.worksSelectOne(data).subscribe(x => {

      let code = x['result'];

      if (code == 202) {
        let data = x['data'];
        this.artist.work_list.push(data);
      }

    })

  }

}
