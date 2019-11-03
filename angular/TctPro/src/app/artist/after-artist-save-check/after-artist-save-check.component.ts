import { Component, OnInit } from '@angular/core';
import { ArtistService } from '../artist.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-after-artist-save-check',
  templateUrl: './after-artist-save-check.component.html',
  styleUrls: ['./after-artist-save-check.component.css']
})
export class AfterArtistSaveCheckComponent implements OnInit {

  constructor(private artistService: ArtistService,
    private route: ActivatedRoute,
    private router: Router) { }

  artistId: number;
  add = {
    worksAdd: false,
    artistAdd: false,
    evaluateAdd: false
  }

  data = {
    work: {
      subject: "",
    },
    artist: {
      art_name: "",
    },
  }

  ngOnInit() {

    this.route.params.subscribe(x => {
      this.artistId = x.id;
      this.artistService.selectArtistOne({ 'id': this.artistId }).subscribe(x => {
        console.log(x);

        let code = x['result'];

        if (code == 202) {

          this.data.artist = x['data']['artistDto'];
          this.add.artistAdd = true;

        } else if (code == 200) {

          this.data.artist = x['data']['artistDto'];
          this.data.work = x['data']['worksDto'];
          this.add.artistAdd = true;
          this.add.worksAdd = true;
          this.add.evaluateAdd = true;

        }
      });
    })

  }

  worksAdd() {

    let artist = this.data.artist;
    this.router.navigate(['/works/addWork', artist['artist_id']])

  }

}
