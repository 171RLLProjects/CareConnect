import { TestBed, inject } from '@angular/core/testing';

import { OcsServiceService } from './ocs-service.service';

describe('OcsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OcsServiceService]
    });
  });

  it('should be created', inject([OcsServiceService], (service: OcsServiceService) => {
    expect(service).toBeTruthy();
  }));
});
