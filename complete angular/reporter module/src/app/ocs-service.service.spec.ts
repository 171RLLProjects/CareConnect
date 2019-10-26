import { TestBed, inject } from '@angular/core/testing';

import { OcsService } from './ocs.service';

describe('OcsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OcsService]
    });
  });

  it('should be created', inject([OcsService], (service: OcsService) => {
    expect(service).toBeTruthy();
  }));
});
