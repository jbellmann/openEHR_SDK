package org.ehrbase.client.classgenerator.examples.alternativeeventscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.body_weight.v2")
public class KorpergewichtObservation {
  /**
   * Bericht/Körpergewicht/*Birth(en)
   */
  @Path("/data[at0002]/events[at0026]")
  private KorpergewichtBirthEnPointEvent birthEn;

  /**
   * Bericht/Körpergewicht/origin
   */
  @Path("/data[at0002]/origin|value")
  private TemporalAccessor originValue;

  /**
   * Bericht/Körpergewicht/Gerät
   */
  @Path("/protocol[at0015]/items[at0020]")
  private Cluster gerat;

  /**
   * Bericht/Körpergewicht/*Extension(en)
   */
  @Path("/protocol[at0015]/items[at0027]")
  private List<Cluster> extensionEn;

  /**
   * Bericht/Körpergewicht/subject
   */
  @Path("/subject")
  private PartyProxy subject;

  /**
   * Bericht/Körpergewicht/language
   */
  @Path("/language")
  private Language language;

  /**
   * Bericht/Körpergewicht/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Bericht/Körpergewicht/*Any event(en)
   */
  @Path("/data[at0002]/events[at0003]")
  @Choice
  private List<KorpergewichtAnyEventEnChoice> anyEventEn;

  public void setBirthEn(KorpergewichtBirthEnPointEvent birthEn) {
     this.birthEn = birthEn;
  }

  public KorpergewichtBirthEnPointEvent getBirthEn() {
     return this.birthEn ;
  }

  public void setOriginValue(TemporalAccessor originValue) {
     this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
     return this.originValue ;
  }

  public void setGerat(Cluster gerat) {
     this.gerat = gerat;
  }

  public Cluster getGerat() {
     return this.gerat ;
  }

  public void setExtensionEn(List<Cluster> extensionEn) {
     this.extensionEn = extensionEn;
  }

  public List<Cluster> getExtensionEn() {
     return this.extensionEn ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setAnyEventEn(List<KorpergewichtAnyEventEnChoice> anyEventEn) {
     this.anyEventEn = anyEventEn;
  }

  public List<KorpergewichtAnyEventEnChoice> getAnyEventEn() {
     return this.anyEventEn ;
  }
}
